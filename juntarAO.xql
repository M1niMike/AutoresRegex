xquery version "1.0";

declare variable $author as xs:string external;

<autor>
{
  for $autor in doc("C:/ID/TP_ID_22_23/TP_ID_22_23/autores.xml")//autor[nome = $author]
  order by $autor/nome
  return (
    "&#10;",
    $autor/nome, $autor/dataNascimento, $autor/ocupacoes,
    <livros>
    {
      for $livro in doc("C:/ID/TP_ID_22_23/TP_ID_22_23/obras.xml")//livro[autor = $author]
      order by $livro/titulo
      return (
        "&#10;",
        $livro/titulo
      )
    }
    </livros>
  )
}
</autor>
