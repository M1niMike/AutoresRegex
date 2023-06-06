<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
<xsl:template match="autores">
<html>
<body>
<h1>Autores e suas fotos</h1>
<table border="1">
<tr>
<th>Fotos</th>
<th>Autores</th>
</tr>
<xsl:apply-templates select="autor">
<xsl:sort select="autor"/>
</xsl:apply-templates>
</table>
</body>
</html>
</xsl:template>
<xsl:template match="autor">
<tr>
<td>
<img src="{linkFoto}" width="100"/>
</td>
<td>
<xsl:value-of select="nome"/>
</td>
</tr>
</xsl:template>
</xsl:stylesheet>