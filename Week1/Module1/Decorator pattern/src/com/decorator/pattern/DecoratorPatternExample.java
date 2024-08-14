package com.decorator.pattern;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create an EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the EmailNotifier with SMS and Slack
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSmsAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        // Send notification via Email, SMS, and Slack
        slackSmsAndEmailNotifier.send("System maintenance notification");

        // Alternatively, just SMS and Email
        smsAndEmailNotifier.send("Low disk space warning");
    }
}
