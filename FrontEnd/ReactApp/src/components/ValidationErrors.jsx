import React from 'react';


const ValidationErrors = props => {
  return (
    <div className="validation-errors">
      {props.errors.userName &&
        <div className="alert">
          User Name cannot be numeric or empty.
        </div>
      }
      {props.errors.number &&
        <div className="alert">
          Invalid Card Number.
        </div>
      }
      {props.errors.limit &&
        <div className="alert">
          Limit field must be numeric and >= 100.
        </div>
      }
    </div>
  )
}

export default ValidationErrors;
