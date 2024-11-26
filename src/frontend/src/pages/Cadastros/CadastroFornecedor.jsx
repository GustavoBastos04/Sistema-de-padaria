import React from "react"
import Form from "react-bootstrap/Form";
import {Button, Col, Row} from "react-bootstrap";
import InputMask from 'react-input-mask'

function CadastroFornecedor() {
    return (
        <div>
            <div className="d-flex flex-column align-items-center p-2 min-h-100">
                <Form className="w-25">
                    <Form.Group className="mb-6">
                        <Form.Label> Nome <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="text" placeholder="Bakery Systems" required/>
                        <Form.Label className="mt-3"> CNPJ <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="text" as={InputMask} mask="99.999.999/9999-99" placeholder="01.234.567/0123-45" required/>
                        <Form.Label className="mt-3"> Telefone <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="text" as={InputMask} mask="(99) 91234-5678" placeholder="(11) 91111-1111" required/>
                        <Form.Label className="mt-3"> Email <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="mail" placeholder="bakery@email.com" required/>
                        <Row>
                            <Col>
                                <Form.Label className="mt-3"> Logradouro <span className="required-field">*</span> </Form.Label>
                                <Form.Control type="text" placeholder="Fourth Street." required/>
                            </Col>
                            <Col xs="3">
                                <Form.Label className="mt-3"> Número </Form.Label>
                                <Form.Control type="number" placeholder="123"/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <Form.Label className="mt-3"> Cidade <span className="required-field">*</span> </Form.Label>
                                <Form.Control type="text" placeholder="São Paulo" required/>
                            </Col>
                            <Col xs="6">
                                <Form.Label className="mt-3"> UF <span className="required-field">*</span> </Form.Label>
                                <Form.Control type="text" placeholder="São Paulo" required/>
                            </Col>
                        </Row>
                        <Form.Label className="mt-3"> CEP <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="number" placeholder="01234-567" required/>
                        <Button variant="primary" type="submit" className="w-100 mt-3"> Cadastrar </Button>
                    </Form.Group>
                </Form>
            </div>
        </div>
    )
}

export default CadastroFornecedor