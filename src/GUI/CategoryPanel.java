/**
 * Author : S.Alireza  Moazeni
 * Student Number : 9423110
 * Project 1 : Proxy Server
 * Web Programming winter_spring 1397_1398
 */
package GUI;

import Models.Backend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class CategoryPanel extends ScrollablePanel {
    private Backend back;
    public CategoryPanel(Dimension dim, Backend back) {
        super(dim, back);
        this.back = back;
        this.setBackground(Color.BLUE);
    }

    public void setSelected(MouseEvent e,int catid){
        if(e == null){
            setBackgroundColorOfSelected(catid);
        }
        else{
            for (int i = 0; i < back.categories.size(); ++i){
                if(e.getSource().equals(back.categories.get(i))){
                    setBackgroundColorOfSelected(i);
                    break;
                }
            }
        }

    }

    private void setBackgroundColorOfSelected(int id){
        back.currentSelectedCategory = id;
        for (int i = 0; i < back.categories.size(); ++i){
            if(i == id){
                back.categories.get(i).setBackground(new Color(249, 132, 132));
                ((categoryItem)(back.categories.get(i))).selectChk.setBackground(new Color(249, 132, 132));
                back.ui.urlsPanel.itemsList.updateListView(back.urls.get(i));
            }
            else{
                back.categories.get(i).setBackground(new Color(240, 240, 240));
                ((categoryItem)(back.categories.get(i))).selectChk.setBackground(new Color(240, 240, 240));
            }
        }
    }
    public void setCheckBoxStatus(ActionEvent e){
        for (int i = 0; i < back.categories.size(); ++i){
            if(((categoryItem)back.categories.get(i)).selectChk.equals(e.getSource())){
                if(((categoryItem)back.categories.get(i)).selectChk.isSelected()){
                    for (int j = 0; j < back.urls.get(i).size(); ++j)
                        ((urlItem)back.urls.get(i).get(j)).selectChk.setSelected(true);
                }else{
                    for (int j = 0; j < back.urls.get(i).size(); ++j)
                        ((urlItem)back.urls.get(i).get(j)).selectChk.setSelected(false);
                }
                break;
            }
        }
    }

    public void deleteCategory(MouseEvent e){
        for (int i = 0; i < Backend.categories.size(); ++i){
            if(e.getSource().equals(((categoryItem)Backend.categories.get(i)).deleteButton)){
                back.deleteCategory(i);
                break;
            }
        }
    }
}
