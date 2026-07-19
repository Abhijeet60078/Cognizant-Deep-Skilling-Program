import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

    constructor(props) {

        super(props);

        this.items = [

            new Cart("Laptop", 65000),
            new Cart("Mobile", 25000),
            new Cart("Headphones", 3000),
            new Cart("Keyboard", 1500),
            new Cart("Mouse", 800)

        ];

    }

    render() {

        return (

            <div className="container">

                <h2>Online Shopping Cart</h2>

                <table>

                    <thead>

                        <tr>

                            <th>Item Name</th>
                            <th>Price (₹)</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            this.items.map((item, index) => (

                                <tr key={index}>

                                    <td>{item.itemName}</td>

                                    <td>{item.price}</td>

                                </tr>

                            ))

                        }

                    </tbody>

                </table>

            </div>

        );

    }

}

export default OnlineShopping;