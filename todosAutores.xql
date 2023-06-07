xquery version "1.0";


for $x in doc("C:/ID/TP_ID_22_23/TP_ID_22_23/autores.xml")//autor
order by $x/nome
return ("&#10;","Nome: ",
$x/nome/text())