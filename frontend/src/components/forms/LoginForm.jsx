import React from "react";

class LoginForm extends React.Component {
  state = {
    account: {
      username: "",
      password: "",
    },

    errors: {},
  };

  validate() {
    const errors = {};

    if (this.state.account.username.trim() === "")
      errors.username = "Username is required.";

    if (this.state.account.password.trim() === "")
      errors.password = "Password is required.";

    return Object.keys(errors).length === 0 ? null : errors;
  }

  handleSubmit = (e) => {
    e.preventDefault();

    const username = this.state.account.username;
    const password = this.state.account.password;

    const errors = this.validate();
    this.setState({ errors });
    console.log(errors);
    if (errors) return;

    //call server and log in user & route user somewhere
    console.log(
      "Submitted with login: {} and password: {}",
      username,
      password
    );
  };

  handleChange = (e) => {
    const account = { ...this.state.account };
    account[e.currentTarget.name] = e.currentTarget.value;
    this.setState({ account });
  };

  render() {
    return (
      <div>
        <h1>Login</h1>
        <form action="" onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input
              value={this.state.account.username}
              onChange={this.handleChange}
              id="username"
              name="username"
              autoFocus
              ref={this.username}
              type="text"
              className="form-control"
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              value={this.state.account.password}
              onChange={this.handleChange}
              id="password"
              name="password"
              type="password"
              className="form-control"
            />
          </div>
          <button className="btn btn-primary">Submit</button>
        </form>
      </div>
    );
  }
}

export default LoginForm;
