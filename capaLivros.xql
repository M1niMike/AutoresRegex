xquery version "1.0";

declare variable $author as xs:string external;



<book>
{
	<livro>
	{
		for $x in  doc("C:/ID/TP_ID_22_23/TP_ID_22_23/obras.xml")//livro[autor = $author]
		order by $x/titulo
		return ("&#10;",
		$x/titulo, $x/fotoCapa)
	}
	</livro>
}
</book>

