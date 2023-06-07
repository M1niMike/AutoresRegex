xquery version "1.0";


for $x in doc("C:/ID/TP_ID_22_23/TP_ID_22_23/autores.xml")//autor
order by $x/conjuge
return ("&#10;","Nome do Autor: ",
$x/nome/text(),"&#10;","Ocupacoes: ",
$x/ocupacoes, "&#10;")