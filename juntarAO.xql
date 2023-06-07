xquery version "1.0";

declare namespace doc = "http://www.w3.org/2005/xpath-functions/doc";
<autores>
{
  for $autor in doc("file:///C:/ID/TP_ID_22_23/TP_ID_22_23/autores.xml")//autor
  order by $autor/nome
  return (
    <autor>
      {
        "&#10;",
        $autor/nome, $autor/dataNascimento, $autor/ocupacoes,
        <livros>
        {
          for $l in doc("file:///C:/ID/TP_ID_22_23/TP_ID_22_23/obras.xml")//livro, $a in doc("file:///C:/ID/TP_ID_22_23/TP_ID_22_23/autores.xml")//autor
          where $l/autor = $a/nome and $a/nome = $autor/nome
          order by $l/titulo
          return (
            "&#10;",
            $l/titulo
          )
        }
        </livros>
      }
    </autor>
  )
}
</autores>