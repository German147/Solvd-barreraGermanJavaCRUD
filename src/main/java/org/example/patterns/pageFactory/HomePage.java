package org.example.patterns.pageFactory;

public class HomePage implements IAbstractsPageClasses{
    @Override
    public void createPage() {
        System.out.println("Creating Home Page");
    }
}
