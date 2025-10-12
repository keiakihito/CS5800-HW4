package ecommerce.app;

import ecommerce.channels.EmailChannel;
import ecommerce.channels.SmsChannel;
import ecommerce.channels.PushChannel;
import ecommerce.channels.NotificationChannel;
import ecommerce.payments.OnlinePaymentNotification;
import ecommerce.payments.CashOnDeliveryPayment;
import ecommerce.payments.BitcoinPayment;
import ecommerce.payments.PaymentNotification;

/**
 * Driver program demonstrating the Bridge Design Pattern
 * Shows how different payment types can work with different notification channels
 * Author: Keita Katsumi
 * CS 5800 Fall 2025
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern: E-commerce Payment Notification System ===\n");

        // Part 1: Basic scenarios with OnlinePayment and CashOnDelivery
        System.out.println("--- Part 1: Basic Payment Types ---");

        // Scenario 1: Online payment with Email
        System.out.println("\n1. Online Payment + Email Channel:");
        PaymentNotification onlineEmail = new OnlinePaymentNotification(new EmailChannel()); // Dependency Injection
        String result = onlineEmail.notifyCustomer("Payment of $100 processed successfully");
        System.out.println(result);

        // Scenario 2: Online payment with SMS
        System.out.println("\n2. Online Payment + SMS Channel:");
        NotificationChannel smsChannel = new SmsChannel();
        PaymentNotification onlineSms = new OnlinePaymentNotification(smsChannel);
        result = onlineSms.notifyCustomer("Payment of $100 processed successfully");
        System.out.println(result);

        // Scenario 3: Cash on Delivery with Email
        System.out.println("\n3. Cash on Delivery + Email Channel:");
        PaymentNotification cashEmail = new CashOnDeliveryPayment(new EmailChannel()); // Dependency Injection
        result = cashEmail.notifyCustomer("Your order will arrive in 2-3 business days");
        System.out.println(result);

        // Scenario 4: Cash on Delivery with SMS
        System.out.println("\n4. Cash on Delivery + SMS Channel:");
        smsChannel = new SmsChannel();
        PaymentNotification cashSms = new CashOnDeliveryPayment(smsChannel);
        result = cashSms.notifyCustomer("Your order will arrive in 2-3 business days");
        System.out.println(result);



        // Part 2: Bitcoin payment scenarios
        System.out.println("\n\n--- Part 2: Bitcoin Payment ---");

        // Scenario 5: Bitcoin with Email
        System.out.println("\n5. Bitcoin Payment + Email Channel:");
        PaymentNotification bitcoinEmail = new BitcoinPayment(new EmailChannel()); // Dependency Injection
        result = bitcoinEmail.notifyCustomer("0.0025 BTC received - Transaction confirmed");
        System.out.println(result);

        // Scenario 6: Bitcoin with SMS
        System.out.println("\n6. Bitcoin Payment + SMS Channel:");
        PaymentNotification bitcoinSms = new BitcoinPayment(new SmsChannel()); // Dependency Injection
        result = bitcoinSms.notifyCustomer("0.0025 BTC received - Transaction confirmed");
        System.out.println(result);




        // Part 3: Push notification channel scenarios
        System.out.println("\n\n--- Part 3: Push Notification Channel ---");

        // Scenario 7: Online payment with Push
        System.out.println("\n7. Online Payment + Push Channel:");
        PaymentNotification onlinePush = new OnlinePaymentNotification(new PushChannel()); // Dependency Injection
        result = onlinePush.notifyCustomer("Payment of $150 processed successfully");
        System.out.println(result);

        // Scenario 8: Bitcoin with Push
        System.out.println("\n8. Bitcoin Payment + Push Channel:");
        PaymentNotification bitcoinPush = new BitcoinPayment(new PushChannel()); // Dependency Injection
        result = bitcoinPush.notifyCustomer("0.0030 BTC received - Transaction confirmed");
        System.out.println(result);

    }
}



/*Sample Run:
~/Dropbox/Academic/CalPolyPomona/2025/2025Fall/CS5800/HW/HW4 main*
❯   mvn compile exec:java -Dexec.mainClass="ecommerce.app.Driver" -pl bridge

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< com.calpoly:bridge >-------------------------
[INFO] Building Bridge Pattern - E-commerce Notification System 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco:0.8.10:prepare-agent (default) @ bridge ---
[INFO] argLine set to -javaagent:/Users/keita-katsumi/.m2/repository/org/jacoco/org.jacoco.agent/0.8.10/org.jacoco.agent-0.8.10-runtime.jar=destfile=/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2025/2025Fall/CS5800/HW/HW4/bridge/target/jacoco.exec
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ bridge ---
[INFO] skip non existing resourceDirectory /Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2025/2025Fall/CS5800/HW/HW4/bridge/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ bridge ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 10 source files with javac [debug target 11] to target/classes
[WARNING] system modules path not set in conjunction with -source 11
[INFO] 
[INFO] --- exec:3.6.1:java (default-cli) @ bridge ---
=== Bridge Pattern: E-commerce Payment Notification System ===

--- Part 1: Basic Payment Types ---

1. Online Payment + Email Channel:
[Email] [Online Payment]: Payment of $100 processed successfully

2. Online Payment + SMS Channel:
[SMS] [Online Payment]: Payment of $100 processed successfully

3. Cash on Delivery + Email Channel:
[Email] [Cash on Delivery]: Your order will arrive in 2-3 business days

4. Cash on Delivery + SMS Channel:
[SMS] [Cash on Delivery]: Your order will arrive in 2-3 business days


--- Part 2: Bitcoin Payment ---

5. Bitcoin Payment + Email Channel:
[Email] [Bitcoin Payment]: 0.0025 BTC received - Transaction confirmed

6. Bitcoin Payment + SMS Channel:
[SMS] [Bitcoin Payment]: 0.0025 BTC received - Transaction confirmed


--- Part 3: Push Notification Channel ---

7. Online Payment + Push Channel:
[Push] [Online Payment]: Payment of $150 processed successfully

8. Bitcoin Payment + Push Channel:
[Push] [Bitcoin Payment]: 0.0030 BTC received - Transaction confirmed
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.261 s
[INFO] Finished at: 2025-10-12T14:25:52-07:00
[INFO] ------------------------------------------------------------------------
*/