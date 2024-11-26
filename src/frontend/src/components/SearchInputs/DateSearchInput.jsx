import React from "react"
import { Form, InputGroup, Button } from "react-bootstrap"
import PropTypes from "prop-types"
import { useState } from "react"

function DateSearchInput({ onSearch }) {
    const [iDate, setIDate] = useState("")
    const [fDate, setFDate] = useState("")

    const handleSearch = () => {
        onSearch(iDate, fDate)
    };

    return (
        <div className="p-2 d-flex flex-row align-items-center justify-content-center">
            <Form className="mb-3 w-50 d-flex justify-content-center gap-2">
                <InputGroup className="mb-2 h-25">
                    <InputGroup.Text>Data Inicial</InputGroup.Text>
                    <Form.Control
                        type="date"
                        placeholder="Insira a data inicial"
                        value={iDate}
                        onChange={(e) => setIDate(e.target.value)}
                    />
                </InputGroup>
                <InputGroup className="mb-2 h-25">
                    <InputGroup.Text>Data Final</InputGroup.Text>
                    <Form.Control
                        type="date"
                        placeholder="Insira a data final"
                        value={fDate}
                        onChange={(e) => setFDate(e.target.value)}
                    />
                </InputGroup>
                <Button variant="primary" onClick={handleSearch} className="h-25">
                    Filtrar
                </Button>
            </Form>
        </div>
    );
}

DateSearchInput.propTypes = {
    onSearch: PropTypes.func.isRequired,
};

export default DateSearchInput
