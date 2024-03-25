package setup;

import com.fasterxml.jackson.core.type.TypeReference;
import context.TestContext;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.Generic;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AppiumServerManager {
    static AppiumDriverLocalService server;

    private static void setInstance() {
        loadAppiumServerDetail();
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/usr/local/bin/appium"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(getPort())
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Appiumlog.txt"))
                .withIPAddress(getAddress());

        server = AppiumDriverLocalService.buildService(builder);
    }

    private static AppiumDriverLocalService getInstance(){
        if(server == null){
            setInstance();
        }
        return server;
    }

    public static void start(){
        getInstance().start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }

    public static void loadAppiumServerDetail() {
        List<AppiumServerDetail> appiumServerDetailsList;
        try {
            appiumServerDetailsList = Generic.convertJsonFileToModel("src/test/resources/appiumServerDetails.json", new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // The predicate to filter the servers based on isLocalMode
        Predicate<AppiumServerDetail> filterPredicate = TestContext.isLocalMode ?
                asd -> "local".equals(asd.mode()) :
                asd -> !"local".equals(asd.mode());

        // Find the first server that matches the criteria and return its URL
        Optional<AppiumServerDetail> serverDetailOptional = appiumServerDetailsList.stream()
                .filter(filterPredicate)
                .findFirst();

        // If a server is found, return its URL, otherwise return an empty or placeholder string
        TestContext.appiumServerDetail = serverDetailOptional.orElse(null);
    }

    private static int getPort(){
        return Integer.parseInt(TestContext.appiumServerDetail.url().split(":")[2]);
    }

    private static String getAddress(){
        return TestContext.appiumServerDetail.url().split(":")[1].replace("//","");
    }
}
