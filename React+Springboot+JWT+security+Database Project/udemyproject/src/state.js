import React, { Component } from "react";

export default class extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0,
    };
  }
  handleIncrement = () => {
    this.setState(
      //shob somoy state er value setState diye change krte hobe
      { count: this.state.count + 1 }
    );
  }
  handleDecrement = () => {
    this.setState(
      //shob somoy state er value setState diye change krte hobe
      { count: this.state.count -1 }
    );
  }
  render() {
    const { count } = this.state;
    return (
      <div>
        <h1>count :{count}</h1>
        <button onClick={this.handleIncrement}>+</button>
        <button onClick={this.handleDecrement} disabled={count===0 ? true:false}>-</button>

        </div>
    );
  }
}
