public class nilaiRata 
{
    public float rata (int total) //total pengambilan nilai total yg ada pada class data_mahasiswa
    {
        return(total/2); //menentukan nilai rata - rata
    }
    
    public String nilaiHuruf(int total)  //menentukan nilai huruf sesuai nilai rata - rata
    {
        if ((total/2)>=80 && (total/2)<=100) // jika nnilai rata - rata 80 - 100 nilai huruf A
            return "A";
        else if ((total/2)>=75 && (total/2)<80) // jika nnilai rata - rata 75 - 80 nilai huruf B+
            return "B+";
        else if ((total/2)>=65 && (total/2)<75) // jika nnilai rata - rata 65 - 75 nilai huruf B
            return "B";
        else if ((total/2)>=60 && (total/2)<65) // jika nnilai rata - rata 60 - 65 nilai huruf C+
            return "C+";
        else if ((total/2)>=50 && (total/2)<60) // jika nnilai rata - rata 50 - 60 nilai huruf C
            return "C";
        else if ((total/2)>=20 && (total/2)<50) // jika nnilai rata - rata 20 - 50 nilai huruf D
            return "D";
        else if ((total/2)>=0 && (total/2)<20) // jika nnilai rata - rata 0 - 20 nilai huruf E
            return "E";
        else //selain dari syarat diatas maka akan keluar output error
            return "Error";
    }
}
