
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
//7 deklarasi diatas merupakan deklarasi librari yg akan digunakan pada class data_mhs ini

public class data_mhs extends JFrame //extends berfungsi untuk menghubungkan class data_mhs dengan JFrame
{
    JLabel nim,nama,matkul1,matkul2,nilai1,nilai2; //deklarasi label untuk masing - masing tulisan pada GUI
    JTextField isinama,isinim,isimatkul1,isimatkul2,isinilai1,isinilai2; //deklarasi label untuk masing - masing input pada GUI
    JButton ok; //deklarasi button untuk convert pada GUI
    Statement statement; //deklarasi penggunaan statement
    
    public void data_mhs()
    {
        setTitle("Hitung Nilai"); //untuk menentukan judul atau nama GUI
        nim = new JLabel("NIM");
        nama = new JLabel("Nama");
        matkul1 = new JLabel("Mata Kuliah 1");
        nilai1 = new JLabel("Nilai 1");
        matkul2 = new JLabel("Mata Kuliah 2");
        nilai2 = new JLabel("Nilai 2");
        ok = new JButton("Convert");
        isinim = new JTextField();
        isinama = new JTextField();
        isimatkul1 = new JTextField();
        isinilai1 = new JTextField();
        isimatkul2 = new JTextField();
        isinilai2 = new JTextField();
        //13 baris diatas berfungsi untuk membuat atau deklarasi JFrame sesuai dengan tulisan yang diinginkan
        
        setLayout(null); //manajemen layout dimana posisinya dapat diatur sesuai keinginan
        add(nim);
        add(isinim);
        add(nama);
        add(isinama);
        add(matkul1);
        add(isimatkul1);
        add(nilai1);
        add(isinilai1);
        add(matkul2);
        add(isimatkul2);
        add(nilai2);
        add(isinilai2);
        add(ok);
        //13 baris add diatas berfungsi untuk menambahkan data yg akan diatur posisinya pada GUI
        
        nim.setBounds(20,50,100,20);
        isinim.setBounds(140,50,200,20);
        nama.setBounds(20,90,100,20);
        isinama.setBounds(140,90,200,20);
        matkul1.setBounds(20,130,100,20);
        isimatkul1.setBounds(140,130,200,20);
        nilai1.setBounds(20,170,100,20);
        isinilai1.setBounds(140,170,200,20);
        matkul2.setBounds(20,210,100,20);
        isimatkul2.setBounds(140,210,200,20);
        nilai2.setBounds(20,250,100,20);
        isinilai2.setBounds(140,250,200,20);
        ok.setBounds(150,290,90,20);
        //menentukan posisi dengan setBounds (kiri/kanan,atas/bawah,panjang label, lebar label)
        //semakin tinggi angka maka semakin besar ukuran JFrame
        setSize(400,400); // menentukan ukuran GUI
        setVisible(true); // menampilkan GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ok.addActionListener(new ActionListener() //aksi yang akan terjadi jika mengklik button ok(Convert)
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    int nim =  Integer.parseInt(isinim.getText());
                    String nama = isinama.getText();
                    String matkul = isimatkul1.getText();
                    int nilai = Integer.parseInt(isinilai1.getText());
                    String matkul2 = isimatkul2.getText();
                    int nilai2 = Integer.parseInt(isinilai2.getText());
                    //mengambil text yg diinput
                    koneksiDB koneksi = new koneksiDB();
                    //mendeklarasi database
                    try
                    {
                        statement = koneksi.getKoneksi().createStatement();
                        String sql = "INSERT INTO dat_mhs VALUES ('"+ nim + "','" + nama + "','" 
                                     + matkul + "','" + nilai + "','" + matkul2 + "','" + nilai2 + "')";
                        //memasukkan  data yg diinput ke database
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) 
                    {
                        Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) 
                    {
                        Logger.getLogger(data_mhs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    int total = 0; // deklarasi awal nilai total
                    nilaiRata rata = new nilaiRata(); //memanggil class nilaiRata
                    total = nilai+nilai2; //operasi menentukan nilai total
                    System.out.println("NIM           : "+nim);
                    System.out.println("Nama          : "+nama);
                    System.out.println("Mata Kuliah 1 : "+matkul);
                    System.out.println("Mata Kuliah 2 : "+matkul2);
                    System.out.println("Rata - Rata   : "+rata.rata(total)); // melempar nilai total
                    System.out.println("Nilai Huruf   : "+rata.nilaiHuruf(total)); //melempar nilai total
                    //menampilkan data pada output
                } catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                    //bentuk output atau peringatan yg terjadi bila yg diinput tidak sesuai dengan format
                } catch (Error ext)
                {
                    JOptionPane.showMessageDialog(rootPane,"SALAH");
                    //bentuk output atau peringatan yg terjadi error
                }
            }
            //kode yg berada didalam try merupakan kode yang mungkin dapat menimbulkan exception
            //kode yg berada pada catch merupakan reaksi atau peringatan yg akan keluar saat terjadi exeption
        });
    }
}
