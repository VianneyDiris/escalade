<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>

<body>
<h1>Struts 2 file upload example</h1>

<s:form action="resultAction" namespace="/" 
method="POST" enctype="multipart/form-data">

<s:file name="fileUpload" label="Select a File to upload" size="40" />
<s:textfield name="content" class="form-control" placeholder=""/>

<s:submit value="submit" name="submit" />
	
</s:form>

</body>
</html>