<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
<xsl:template match="book">
<html>
<body>
<h1>Capa dos Livros</h1>
<table border="1">
<tr>
<th>Capa</th>
<th>Autores</th>
</tr>
<xsl:apply-templates select="livro">
<xsl:sort select="livro"/>
</xsl:apply-templates>
</table>
</body>
</html>
</xsl:template>
<xsl:template match="livro">
<tr>
<td>
<img src="{fotoCapa}" width="250"/>
</td>
<td>
<xsl:value-of select="titulo"/>
</td>
</tr>
</xsl:template>
</xsl:stylesheet>