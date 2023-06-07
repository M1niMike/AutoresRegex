<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html"/>
   
   <xsl:template match="/">
      <html>
         <body>
            <h1>Autores e suas fotos</h1>
            <table border="1">
               <tr>
                  <th>Foto de Capa</th>
                  <th>Foto do Autor</th>
               </tr>
               <xsl:apply-templates select="autores/autor[livros/fotoCapa and linkFoto]"/>
            </table>
         </body>
      </html>
   </xsl:template>
   
   <xsl:template match="autor">
      <tr>
         <td>
            <img src="{livros/fotoCapa}" width="100"/>
         </td>
         <td>
            <img src="{linkFoto}" width="100"/>
         </td>
      </tr>
   </xsl:template>
   
</xsl:stylesheet>
