package com.bhe.test.api;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class DemoApplicationTests extends ApplicationTests {

//        @Test
//        public void apiCalls() {
//            // openWorkspace();
//            System.out.println("Launching first API call");
//            //First API Call
//            postOAuth();
//            System.out.println("Launching Second API call");
//           //Second API Call
//            locateCopy();
//        }

//        @Test
//       public void salesforceWeb() throws InterruptedException {
//            login();
//            verifyServiceAppointStatus();
//            dispatchServiceAppointment();
//        }

        @Test
       public void simulatorAppiumTest() throws MalformedURLException {
            simulatorTest();
        }

//       @AfterTest
//        public void VerifyCompletedJob() {
//          login();
//           CompletedServiceJob();
//     }


    }


