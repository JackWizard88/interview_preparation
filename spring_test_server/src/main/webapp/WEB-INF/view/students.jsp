<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>Students</title>
</head>
<body>
<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/students/new" var="studentEditUrl"/>
            <a class="btn btn-primary" href="${studentEditUrl}">Add Student</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <th scope="row">
                            <c:out value="${student.id}"/>
                        </th>
                        <td>
                            <c:out value="${student.name}"/>
                        </td>
                        <td>
                            <c:out value="${student.age}"/>
                        </td>
                        <td>
                            <c:url value="/students/edit" var="studentEditUrl">
                                <c:param name="id" value="${student.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${studentEditUrl}"><i class="fas fa-edit"></i></a>
                            <c:url value="/students/delete" var="studentDeleteUrl">
                                <c:param name="id" value="${student.id}"/>
                            </c:url>
                            <a class="btn btn-danger" href="${studentDeleteUrl}"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>