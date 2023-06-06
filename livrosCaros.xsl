<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes"/>
	<xsl:template match="obras">
	      <obras>
	      	<xsl:for-each select="livro">
	      		<xsl:sort select="preco" data-type="number" order="descending"/>
				<xsl:if test="position() &lt;= 5">
	     
					
					<obra>
	      				<titulo><xsl:value-of select="titulo"/></titulo>
						<autor><xsl:value-of select="autor"/></autor>
						<preco><xsl:value-of select="preco"/></preco>
	      			</obra>
	      		
	      		</xsl:if>
	      	</xsl:for-each >
	      </obras>	
	</xsl:template>
</xsl:stylesheet>
