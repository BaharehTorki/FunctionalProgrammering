package org.example.gui;

public class StringsConstant {

    final static String BANNER=
            """
             *********************************************************************************************
             *                                                                                           *
             *                                 Välkomen till Online Store                                   *
             *                                                                                           *
             * Please enter your username and password:                                                  *
             * ****************************************************************************************** """;
    public static final String MYPAGE =             """
             ********************************************************************************************
             *          name:%7s    efternamn: %10s                  Today is: %10s         *
             *                                                                                           *
             *     Total beställning: %5d                                                                    *
             *     beställningsNr: %s                                                       *

             *                                                                                           *
             * *******************************************************************************************\n""";
    public static final String MENU="""
            * **************************************  Menu  *********************************************
            *    A(Alla Produkter)          F(Filter)           B(beställning)             X(Exit)       *
            * *******************************************************************************************
             """;
 public static final String FILTER_MENU ="""
            * **************************************  Filter Menu ***************************************
            *      K(Kategori)    S(Storlek)   M(Märke)     F(Färg)   A(Avdelning)   B(Beställning)      *
            * *******************************************************************************************
             """;;

    final static String LOGIN_MSG= "Vänligen ange användarnamn och lösenord för att logga in:";

    public static final String PRODUCT_HEADER =
            "=========================================================================================================\n" +
            "ArticleNr| storlek |    märke    |  color  | pris | categoryType | sectionType | createdDate | update\n" +
            "=========================================================================================================";
    public static final String USER_HEADER =
            "=========================================================================================\n" +
            "   användarnamn    |      namn     |   efternamn    |      address       |     uppdaterad \n"+
            "=========================================================================================";
    public static final String LAGER_HEADER =
            "=========================================================================================\n" +
            "produkt   |  antal |  uppdaterad \n" +
            "=========================================================================================";
    public static final String ORDER_HEADER =
            "=========================================================================================\n" +
            " orderId   |   createdDate   |    product   |   user   |   update \n" +
            "=========================================================================================";


    public static final String EMPTYLINE = """
            
         
            """;
}
