<?php


 include './config/koneksi.php';

//    $connection = mysqli_connect("localhost","root","","dbpulsa") or die("Error " . mysqli_error($connection));

     $vsid = $_GET['vsiduser'];
     $vsidkategorimakanan = $_GET['vsidkastrkategorimakanan'];
     
     // $vsid ='117';
     // $vsidkategorimakanan = 'aneka ayam & bebek';
        
    $sql = "SELECT makanan,foto_makanan,insert_time FROM tblmakanan tm,tbluser tu,tblkategorimakanan tkm WHERE tm.id_user='$vsid' AND tkm.id_kategori = '$vsidkategorimakanan' AND tu.id_user = tm.id_user";

    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
   
    $akhir = array(
	
   	'DataMakanan' => $emparray
    );

 	echo json_encode($akhir);


    //close the db connection
    mysqli_close($connection);
?>
