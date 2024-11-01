import { useState } from "react";
import Form from "react-bootstrap/Form";
import {Button} from "react-bootstrap";

function CadastroProduto() {
    const [ingredientIds, setIngredientIds] = useState([""]); // Estado para armazenar os IDs dos ingredientes

    const handleChange = (index, event) => {
        const values = [...ingredientIds];
        values[index] = event.target.value;
        setIngredientIds(values);
    };

    const handleAddIngredient = () => {
        setIngredientIds([...ingredientIds, ""]); // Adiciona um novo campo
    };

    const handleRemoveIngredient = (index) => {
        const values = [...ingredientIds];
        values.splice(index, 1); // Remove o campo selecionado
        setIngredientIds(values);
    };
    
    return (
        <div>
            <div className="d-flex flex-column align-items-center p-2 min-h-100">
                <Form className="w-25">
                    <Form.Group className="mb-6">
                        <Form.Label> Nome <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="text" placeholder="Bread" required/>
                        <Form.Label className="mt-3"> Valor <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="number" placeholder="R$2.50" required/>
                        <Form.Label className="mt-3"> Quantidade <span className="required-field">*</span> </Form.Label>
                        <Form.Control type="number" placeholder="123" required/>
                        <Form.Label className="mt-3">IDs dos Ingredientes </Form.Label>
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
                        <Button variant="primary" type="submit" className="w-100 mt-3"> Cadastrar </Button>
                    </Form.Group>
                </Form>
            </div>
        </div>
    )
}

export default CadastroProduto