import {Table, Button} from "react-bootstrap";
import ItemProduto from "../components/ListItems/ItemProduto.jsx";

function Produtos() {
    return (
        <div>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Quantidade</th>
                        <th className="text-end">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <ItemProduto 
                    nome="Pão" 
                    valor="2,50" 
                    quantidade="2" 
                    action1={<Button variant="success" className="m-1">Visualizar lucro</Button>}
                    action2={<Button variant="primary" className="m-1">Editar produto</Button>}
                    action3={<Button variant="danger" className="m-1">Remover produto</Button>}
                    />
                </tbody>
            </Table>
        </div>
    )
}

export default Produtos