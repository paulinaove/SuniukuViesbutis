/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.juozo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author paulinaoveraite
 */
@Embeddable
public class CartItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ItemID")
    private int itemID;
    @Basic(optional = false)
    @Column(name = "CartID")
    private int cartID;

    public CartItemPK() {
    }

    public CartItemPK(int itemID, int cartID) {
        this.itemID = itemID;
        this.cartID = cartID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemID;
        hash += (int) cartID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartItemPK)) {
            return false;
        }
        CartItemPK other = (CartItemPK) object;
        if (this.itemID != other.itemID) {
            return false;
        }
        if (this.cartID != other.cartID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication19.CartItemPK[ itemID=" + itemID + ", cartID=" + cartID + " ]";
    }
    
}
