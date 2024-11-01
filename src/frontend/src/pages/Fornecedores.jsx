import {Table} from "react-bootstrap";
import ItemFornecedor from "../components/ListItems/ItemFornecedor.jsx";

function Fornecedores() {
    return (
        <div>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CNPJ</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>CEP</th>
                    </tr>
                </thead>
                <tbody>
                    <ItemFornecedor nome="Uma das cantinas" cnpj="12.123.123/1234.123" tel="(11) 98765-4321" email="canteen@email.com" cep="12345-100"/>
                </tbody>
            </Table>
        </div>
    )
}

export default Fornecedores