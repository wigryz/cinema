import React from "react";
import NavBar from "./components/NavBar";
import LoginForm from "./components/forms/LoginForm";

class App extends React.Component {
  state = {
    page: "movies",
  };

  render() {
    return (
      <React.Fragment>
        <NavBar />
        <main className="container">
          <LoginForm />
        </main>
      </React.Fragment>
    );
  }
}

export default App;
