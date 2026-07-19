import {BrowserRouter,Routes,Route,Link,Navigate}
from "react-router-dom";

import Home from "./components/Home";
import TrainerList from "./components/TrainerList";
import TrainerDetails from "./components/TrainerDetails";

function App(){

return(

<BrowserRouter>

<div>

<h1>Cognizant Academy</h1>

<nav>

<Link to="/home">Home</Link>

&nbsp;&nbsp;&nbsp;

<Link to="/trainers">Trainer List</Link>

</nav>

<hr/>

<Routes>

<Route path="/" element={<Navigate to="/home"/>}/>

<Route path="/home" element={<Home/>}/>

<Route path="/trainers" element={<TrainerList/>}/>

<Route path="/trainer/:id"
element={<TrainerDetails/>}/>

</Routes>

</div>

</BrowserRouter>

);

}

export default App;