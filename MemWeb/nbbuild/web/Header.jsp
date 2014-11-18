<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
            <img id="logo" src="images/mem+.png"
                 onclick="window.location.href = 'Home.jsp'" />

            <div id="container">
                <h2>Olá Parolo <%= session.getAttribute("nome_utilizador") %> </h2>
                <form action="./Inicial?accao=logout" method="post">
                    <div id="lower">
                        <input type="submit" name="logout" value="Logout" />
                    </div>
                </form>
            </div>
    
</html>
