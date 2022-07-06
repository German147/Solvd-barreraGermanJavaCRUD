package org.example.patterns.pageFactory;

public class PageFactory {

    public IAbstractsPageClasses createPage(String page) {
        if (page == null  || page.isEmpty())
            return null;
        switch (page){
            case "Contact":
                return new ContactPage();
            case "Home":
                return new HomePage();
            case "Login":
                return new LoginPage();
            case "Research":
                return new ResearchPage();
            default:
                throw new IllegalArgumentException("Argument does not match "  + page);
        }
    }
}
