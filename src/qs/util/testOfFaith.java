/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.util;

import java.util.List;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.SearchField;

/**
 *
 * @author Maytopacka
 */
public class testOfFaith {

    public static void set(JTextField tf, final List<String> datas, String label) {
       
        final SearchField sf = (SearchField) tf;
        sf.setFont(new java.awt.Font("Tahoma", 0, 12));
        sf.set_instruction1(label);
        sf.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return datas;
            }
        });
    }
}
