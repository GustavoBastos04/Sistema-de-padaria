import { useState } from "react";
import Form from "react-bootstrap/Form"
import {Button} from "react-bootstrap";

function Homepage() {

    const [ingredientIds, setIngredientIds] = useState([""]);

    const handleChange = (index, event) => {
        const values = [...ingredientIds];
        values[index] = event.target.value;
        setIngredientIds(values);
    };

    const handleAddIngredient = () => {
        setIngredientIds([...ingredientIds, ""]);
    };

    const handleRemoveIngredient = (index) => {
        const values = [...ingredientIds];
        values.splice(index, 1);
        setIngredientIds(values);
    };

    return (
        <div>
            <div className="d-flex flex-column align-items-center p-2 min-h-100">
                <Form className="w-25">
                    <Form.Group className="mb-6">
                        <Form.Label> ID do cliente </Form.Label>
                        <Form.Control type="number" placeholder="1234..." />
                        <Form.Label className="mt-3"> IDs dos produtos </Form.Label>
                        {ingredientIds.map((id, index) => (
                            <div key={index} className="d-flex align-items-center mb-1">
                                <Form.Control
                                    type="text"
                                    value={id}
                                    onChange={event => handleChange(index, event)}
                                    placeholder="ID do ingrediente"
                                    className="me-1"
                                    required
                                />
                                <Form.Control type="number" placeholder="Quantidade" className="me-1" required/>
                                <Button variant="danger" onClick={() => handleRemoveIngredient(index)}>Remover</Button>
                            </div>
                        ))}
                        <Button variant="secondary" onClick={handleAddIngredient} className="w-100 mt-2">Adicionar ID</Button>
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