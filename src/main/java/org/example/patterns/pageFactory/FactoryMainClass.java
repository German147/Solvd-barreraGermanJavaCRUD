package org.example.patterns.pageFactory;

public class FactoryMainClass {
    public static void main(String[] args) {
        PageFactory pageFactory = new PageFactory();
        IAbstractsPageClasses IAbstractsPageClasses = pageFactory.createPage("Login");
        IAbstractsPageClasses.createPage();
    }
}
