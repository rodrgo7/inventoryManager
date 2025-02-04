import { useState } from "react";
import axios from "axios";
import "./styles.css";

function App() {
  const [usuario, setUsuario] = useState("");
  const [senha, setSenha] = useState("");
  const [role, setRole] = useState(null); // Guarda o perfil do usuário

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/auth/login", {
        username: usuario,
        password: senha,
      });
  
      if (response.data) {
        setRole(response.data.role);
      } else {
        alert("Usuário ou senha inválidos!");
      }
    } catch (error) {
      alert("Erro ao fazer login!");
    }
  };

  return (
    <div className="container">
      <div className="container-login">
        <div className="wrap-login">
          <form className="login-form" onSubmit={handleLogin}>
            <span className="login-form-title"> Bem vindo </span>

            <div className="wrap-input">
              <input
                className={usuario !== "" ? "has-val input" : "input"}
                type="text"
                value={usuario}
                onChange={(e) => setUsuario(e.target.value)}
              />
              <span className="focus-input" data-placeholder="Login"></span>
            </div>

            <div className="wrap-input">
              <input
                className={senha !== "" ? "has-val input" : "input"}
                type="password"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
              />
              <span className="focus-input" data-placeholder="Senha"></span>
            </div>

            <div className="container-login-form-btn">
              <button type="submit" className="login-form-btn">
                Login
              </button>
            </div>
          </form>

          {role && (
            <h2 className="role-message">
              {role === "ADMIN"
                ? "Bem-vindo, Administrador"
                : "Bem-vindo, Usuário Comum"}
            </h2>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;
