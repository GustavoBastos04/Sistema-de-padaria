import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import NavDropdown from 'react-bootstrap/NavDropdown'

import {Link} from "react-router-dom";

function MainNavbar() {
    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand>Sistema de Padaria</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="/">Nova venda</Nav.Link>
                        <Nav.Link as={Link} to="/produtos">Produtos</Nav.Link>
                        <Nav.Link as={Link} to="/estoque">Estoque</Nav.Link>
                        <Nav.Link as={Link} to="/clientes">Clientes</Nav.Link>
                        <Nav.Link as={Link} to="/fornecedores">Fornecedores</Nav.Link>
                        <NavDropdown title="Históricos" id="basic-nav-dropdown">
                            <NavDropdown.Item as={Link} to="/vendas">Histórico de vendas</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to="/pagamentos">Histórico de pagamentos</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Cadastros" id="basic-nav-dropdown">
                            <NavDropdown.Item as={Link} to="/cliente">Cadastro de cliente</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to="/produto">Cadastro de produto</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to="/fornecedor">Cadastro de fornecedor</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}

export default MainNavbar