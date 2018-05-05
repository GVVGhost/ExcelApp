package excelApp.ghost.gvv;

import java.util.ArrayList;
import java.util.List;

public class CableDAO
{

    public static List<Cable> getListCables()
    {
        return list;
    }

    CableDAO()
    {
        Cable cable = new Cable("",
                                "",
                                "",
                                "",
                                "",
                                "");

        list.add(cable);
    }

    CableDAO(String cL, String cD, String sP, String eP, String cB, String nSC)
    {
        listCables(cL, cD, sP, eP, cB, nSC);
    }

     private static void listCables(String cL, String cD, String sP, String eP, String cB, String nSC)
     {
        list.add(new Cable (cL, cD, sP, eP, cB, nSC));
     }

    private static List<Cable> list = new ArrayList<>();
}
