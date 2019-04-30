/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import qs.settings.Settings;
import qs.util.Center;
import queue.Dlg_queue2;
import queue.Dlg_queue_sme;

/**
 *
 * @author Guinness
 */
public class MyMain {

    public static void main(String[] args) {
        ret_config();
    }

    private static void ret_config() {
        String home = System.getProperty("user.home") + "\\my_config_queue.conf";

        try {

            Properties prop = new Properties();
            String conf = "my_config_queue.conf";
            String userHome = System.getProperty("user.home");
            System.out.println(conf);
            File file = new File(userHome + "/" + conf);
            if (file.exists()) {
                InputStream is = new FileInputStream(file);
                prop.load(is);
            } else {
                file = new File(conf);
                if (file.exists()) {
                    InputStream is = new FileInputStream(file);
                    prop.load(is);
                }
            }

//            System.out.println(home);
            System.setProperty("pool_host", prop.getProperty("pool_host", "localhost"));
            System.setProperty("pool_port", prop.getProperty("pool_port", "3306"));
            System.setProperty("pool_user", prop.getProperty("pool_user", "root"));
            System.setProperty("pool_password", prop.getProperty("pool_password", "synapse246"));
            System.setProperty("pool_db", prop.getProperty("pool_db", "db_queue"));
            System.setProperty("hdd_drive", prop.getProperty("hdd_drive", ""));
            System.setProperty("environment", prop.getProperty("environment", "production"));
            System.setProperty("queue_count", prop.getProperty("queue_count", "3"));
            System.setProperty("version", prop.getProperty("version", ""));
            System.setProperty("VLC_PLUGIN_PATH", prop.getProperty("VLC_PLUGIN_PATH", ""));
            System.setProperty("VLC_PLUGIN_NATIVE_PATH", prop.getProperty("VLC_PLUGIN_NATIVE_PATH", ""));

            System.out.println("Host: " + System.getProperty("pool_host"));
            List<Settings.to_settings> settings = Settings.ret_data("");
            if (!settings.isEmpty()) {
                Settings.to_settings setting = settings.get(0);
                System.setProperty("business_name", prop.getProperty("business_name", setting.business_name));
                System.setProperty("address", prop.getProperty("address", setting.address));
                System.setProperty("operated_by", prop.getProperty("operated_by", ""));
                System.setProperty("contact_no", prop.getProperty("contact_no", setting.contact_no));
                System.setProperty("slogan", prop.getProperty("slogan", ""));
                if (setting.print_queue_no == 0) {
                    System.setProperty("print_queue_no", prop.getProperty("print_queue_no", "false"));
                } else {
                    System.setProperty("print_queue_no", prop.getProperty("print_queue_no", "true"));
                }
                System.setProperty("queue_server_ip", prop.getProperty("queue_server_ip", setting.queue_server_ip));
                System.setProperty("queue_server_port", prop.getProperty("queue_server_port", setting.queue_server_port));
                System.setProperty("location_screen_x", prop.getProperty("location_screen_x", setting.location_screen_x));
                System.setProperty("location_screen_y", prop.getProperty("location_screen_y", setting.location_screen_y));

                System.setProperty("screen_size_x", prop.getProperty("screen_size_x", "" + setting.screen_size_x));
                System.setProperty("screen_size_y", prop.getProperty("screen_size_y", "" + setting.screen_size_y));
                System.setProperty("play_video_sound", prop.getProperty("play_video_sound", "" + setting.play_video_sound));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Window p = (Window) new JFrame();
            Loading nd = Loading.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Loading.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Loading.OutputData data) {
                    new MyMain().start();
                    closeDialog.ok();
                }
            });
            Center.setCenter(nd);
            nd.setVisible(true);
        }
    }

    private void start() {
        Application.setSystemLookAndFeel();
        String version = System.getProperty("version", "");
        if (version.equalsIgnoreCase("sme")) {

            Dlg_queue_sme nd = Dlg_queue_sme.create(new javax.swing.JFrame(), true);
            nd.setTitle("");

            nd.setCallback(new Dlg_queue_sme.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_queue_sme.OutputData data) {
                    closeDialog.ok();

                }
            });
            nd.start_server2();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            nd.setSize(xSize, ySize);
            nd.setVisible(true);
        } else {
            Dlg_queue2 pnl = Dlg_queue2.create(new javax.swing.JFrame(), true);
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/qs/img/link_logo (Custom).png"));
            pnl.setIconImage(image);
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            int sx = FitIn.toInt(System.getProperty("location_screen_x", "0"));
            int sy = FitIn.toInt(System.getProperty("location_screen_y", "0"));

            int screen_size_x = FitIn.toInt(System.getProperty("screen_size_x", "1366"));
            int screen_size_y = FitIn.toInt(System.getProperty("screen_size_y", "768"));

            pnl.setLocation(sx, sy);
            pnl.setSize(screen_size_x, screen_size_y);
//        pnl.set_font();
            pnl.setSize();
            pnl.set_lib();
            pnl.start_server2();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    pnl.set_player();
                }
            });
            pnl.setVisible(true);
        }

    }

    public static String getSerialNumber() {
        String drive = System.getProperty("hdd_drive", "");

        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.trim();
    }
}
