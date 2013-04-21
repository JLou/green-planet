package IA;

import greenplanetclient.Game;
import greenplanetclient.Order;
import greenplanetclient.Player;
import java.util.ArrayList;

/**
 *
 * @author JLou
 */
public class IA 
{
    public IA()
    {
        
    }
    
    public Order takeDecision(Game game)
    {
        Order order;
        ArrayList l = new ArrayList();
        float cash;
        float energy;
        int nucl = 0, wind = 0, water = 0, sun = 0, charb = 0;
        
        Player us = game.getPlayers().get(0);
        for (Player p : game.getPlayers()) {
            if (p.getName().equals("JLou")) {
                us = p;
            }
        }
        cash = us.getCash();
        while ((cash > 600) && (charb < 5)) {
            l.add("coal_fired_plant");
            l.add("wind_turbine");
            l.add("wind_turbine");
            charb++;
            wind = wind + 2;
            cash = cash - 600;
        }
        if (cash > 500) {
            l.add("water_turbine");
            water++;
            cash = cash - 500;
        }
        while ((cash > 100) && (wind < 15)) {
            l.add("wind_turbine");
            wind++;
            cash = cash - 100;
        }
        System.out.println("Cash:" + cash);
        for (Object s : l) {
            System.out.println(s);
        }
        energy = us.getPowerAvailable() - us.getPowerNeed() / 100 * 20;
        // give order, wait for next turn
        if (game.getTurn() != 1) {
            order = new Order(-((int) energy), l);
        } else {
            order = new Order(0, l);
        }
        
        return order;
    }
}
