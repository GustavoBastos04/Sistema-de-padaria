import Form from "react-bootstrap/Form"
import {Button, Col, Row} from "react-bootstrap";

function Homepage() {
    return (
        <div>
            <div className="d-flex flex-column align-items-center p-2 min-h-100">
                <Form className="w-25">
                    <Form.Group className="mb-6">
                        <Row>
                            <Col>
                                <Form.Label> ID do cliente </Form.Label>
                                <Form.Control type="number" placeholder="1234..." />
                            </Col>
                            <Col xs="6">
                                <Form.Label> ID do produto </Form.Label>
                                <Form.Control type="number" placeholder="1234..." />
                            </Col>
                        </Row>
                        <Form.Label className="mt-3"> Quantidade </Form.Label>
                        <Form.Control type="number" placeholder="1234..." />
                        <Form.Label className="mt-3"> Forma de pagamento </Form.Label>
                        <Form.Select>
                            <option value="1">Cartão de crédito</option>
                            <option value="2">Cartão de débito</option>
                            <option value="3">Pix</option>
                            <option value="4">Dinheiro</option>
                        </Form.Select>
                        <Button variant="primary" type="submit" className="w-100 mt-3"> Realizar venda! </Button>
                    </Form.Group>
                </Form>
            </div>
        </div>
    )
}

export default Homepage