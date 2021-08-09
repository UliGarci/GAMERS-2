<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String context = request.getContextPath(); %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Videojuegos</title>
    <link href="../CSS/index.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="contenido">
    <h2>Videojuegos</h2>
</div>
<div>
    <a type="button" href="games?action=create" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalregister">Agregar</a><br><br>
</div>
<div>
    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre del juego</th>
                <th>Fecha de registro</th>
                <th>Status</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGame}" var="game" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${game.getNombre()}</td>
                <td>${game.getFecha()}</td>
                <td>
                    <c:if test="${game.getStatus == 1}">
                        <span class="badge bg-success">Activo</span>
                    </c:if>
                    <c:if test="${game.getStatus == 0}">
                        <span class="badge bg-dangger">Inactivo</span>
                    </c:if>
                </td>
                <td>${game.getDescripcion()}</td>
                <td>
                    <button type="button" class="btn btn-primary">Modificar</button>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#delete">Eliminar</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%-- MODAL ELIMINAR --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar videojuego </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-danger">Eliminar</button>
            </div>
        </div>
    </div>
</div>

<%-- MODAL registrar --%>
<div class="modal fade" id="modalregister" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar nuevo juego</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
                <div class="modal-body" action="${Context}/ServletGame" method="POST">
                    <label class="form-label">Nombre:</label>
                    <input type="text" class="form-control" name="name">
                    <label class="form-label">fecha de registro:</label>
                    <input type="text" class="form-control" name="fecha">
                    <label class="form-label">Status:</label>
                    <input type="text" class="form-control" name="status">
                    <label class="form-label">Descripción:</label>
                    <input type="text" class="form-control" name="descripcion">
                </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="JS/index.js"></script>
</body>
</html>
