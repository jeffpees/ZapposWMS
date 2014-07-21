<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <table class="table">
                <th>Package Order</th>
                <tr>
                    <td>Order Number</td>
                    <td>Type</td>
                    <td>Size</td>
                    <td>Box Number</td>
                </tr>
                <tr>
                    <td>${welcome.testorderNumber}</td>
                    <td>${welcome.testtype} </td>
                    <td>${welcome.testsize} </td>
                    <td>${welcome.testboxNumber}</td>
                </tr>
            </table>
        </div>
    </div>
</section>
</body>
</html>