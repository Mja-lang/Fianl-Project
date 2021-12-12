package com.Mujo;

public class PresidentDAOFactory {
        private static final String DA_SOURCE = "CSV";

        public static PresidentDAO getPresidentDAO(){
            PresidentDAO da = null;
            switch(DA_SOURCE){
                case "CSV":
                    da = new PresidentDAOCSV();
                    break;
 //               case "XML":
 //                   da = new PresidentXML();
 //                   break;
                case "MYSQL":
                    da = new PresidentDAOMySQL();
                    break;
                default:
            }
            return da;
        }

}
