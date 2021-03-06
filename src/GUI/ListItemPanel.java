/**
 * Author : S.Alireza  Moazeni
 * Student Number : 9423110
 * Project 1 : Proxy Server
 * Web Programming winter_spring 1397_1398
 */
package GUI;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class ListItemPanel extends JPanel {

    protected SpringLayout sp;
    protected Dimension screenSize;

    public ListItemPanel(Dimension dim){
        super();
        sp = new SpringLayout();
        screenSize = dim;
        setLayout(sp);
        setPreferredSize(dim);
        setOpaque(false);
    }

    /**
     * update view with new objects
     * @param items
     */
    public void updateListView(ArrayList<ListItem> items){
        this.setPreferredSize(screenSize);
        Component[] components = this.getComponents();

        for (Component component : components) {
            this.remove(component);
        }

        this.revalidate();
        this.repaint();

        if(items == null || items.size() == 0)
            return;
        int itemH = items.get(0).getPreferredSize().height;
        for (int i = 0; i < items.size(); i++){
            ListItem li = items.get(i);
            add(li);
            if(i == 0)
                sp.putConstraint(SpringLayout.NORTH, li, 2, SpringLayout.NORTH, this);
            else
                sp.putConstraint(SpringLayout.NORTH, li, 2, SpringLayout.SOUTH, items.get(i-1));

            sp.putConstraint(SpringLayout.WEST, li, 0, SpringLayout.WEST, this);
        }
        if(items.size() * itemH > screenSize.height){
            this.setPreferredSize(new Dimension(screenSize.width, items.size() * (itemH + 2) + 5));
        }
        updateUI();
    }

}
