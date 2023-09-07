import React from 'react'

const Child=(props)=> {
    const data="i am from Norway";
   props.onChildData(data);
  return (
    <div>

<p>I am child</p>
      <p>{props.data}</p>
    </div>
  )
}
export default Child;