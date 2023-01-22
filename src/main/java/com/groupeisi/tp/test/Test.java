package com.groupeisi.tp.test;

import com.groupeisi.tp.dao.CompteDAO;
import com.groupeisi.tp.dao.DroitDAO;
import com.groupeisi.tp.entities.Compte;
import com.groupeisi.tp.entities.Droit;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]){
        DroitDAO droitDAO = new DroitDAO();
        Droit droit = new Droit();
        CompteDAO compteDAO = new CompteDAO();
        Compte compte = new Compte();
        droit.setName("RH");
        List<Compte> comptes = new ArrayList<Compte>();
        comptes.add(compteDAO.get(3, compte));
        droit.setComptes(comptes);
        int result = droitDAO.add(droit);
        System.out.println(result);

    }
}
