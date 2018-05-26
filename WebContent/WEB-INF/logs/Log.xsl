<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Demo Application</h2>

    <table border="1">
      <tr bgcolor="#9acd32">
        <th>LogType</th>
        <th>Timestamp</th>
        <th>Description</th>
      </tr>
      <xsl:apply-templates/>
    </table>
  </body>
  </html>
</xsl:template>

<xsl:template match="Info">
<tr>
  <td>
    <b>Info:</b></td>
  <td><span style="color:#2B1B17"><xsl:value-of select="Timestamp"/></span></td>
  <td><span style="color:#CC00CC"><xsl:value-of select="Desc"/></span></td>
</tr>
</xsl:template>

<xsl:template match="Debug">
<tr>
  <td>
    <b>Debug:</b></td> 
  <td><span style="color:#2B1B17"><xsl:value-of select="Timestamp"/></span></td>
  <td><span style="color:#008080"><xsl:value-of select="Desc"/></span></td>
</tr>
</xsl:template>

<xsl:template match="Error">
<tr>
  <td>
    <b>Error:</b></td>
  <td><span style="color:#2B1B17"><xsl:value-of select="Timestamp"/></span></td>
  <td>
    <b><span style="color:#FF0000"><xsl:value-of select="Desc"/></span></b>
  </td>
</tr>
</xsl:template>

</xsl:stylesheet>

