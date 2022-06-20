import React from 'react';


const Form = props => {
  return (
    <div className="form">
      <p> Name </p>
      <input type="text" name="userName"
             value={props.card.userName}
             onChange={props.handleInputChange} />
      <p> Card number </p>
      <input type="text" name="number"
             value={props.card.number}
             onChange={props.handleInputChange} />
      <p> Limit </p>
      <input type="number" name="limit"
             value={props.card.limit}
             onChange={props.handleInputChange} />
      <button onClick={props.addCard}> Add </button>
    </div>
  );
}

export default Form;
