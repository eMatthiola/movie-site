import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faVideoSlash } from "@fortawesome/free-solid-svg-icons";
import { Button } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    // variant for font white color 
   <Navbar bg="dark" variant="dark" expand="lg"> 
        <Container fluid>
            <Navbar.Brand href="/" style={{"color":'gold'}}>
                <FontAwesomeIcon icon={faVideoSlash}/>Reiner
            </Navbar.Brand>
            {/* toggle in phone */}
            <Navbar.Toggle aria-controls="navbarScroll"/> 
            <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{maxHeight: '100px'}}
                        navbarScroll
                    >
                        <NavLink className="nav-link" to="/">Home</NavLink>
                        <NavLink className="nav-link" to="/watchList">Watch List</NavLink>
                    </Nav>
                     {/*  variant="outline-info" Blue Outline info button */}
                    <Button variant="outline-info" className="me-3">Login</Button>
                    <Button variant="outline-info">Register</Button>
            </Navbar.Collapse>
        </Container>
   </Navbar>
  )
}

export default Header
